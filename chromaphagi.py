class chromaphagi:
    def __init__(self, chroma) -> None:
        self.chroma = chroma
        self.starting_position = (0, 0)

    def set_start_position(self, coordinates):
        self.chroma.add_to_tracker(coordinates)

    def step(self, config: dict, image) -> str:
        return self.chroma.step_strain(config, image)


_vonNeumann = {
    "up": (0, -1),
    "upright": (1, -1),
    "right": (1, 0),
    "downright": (1, 1),
    "down": (0, 1),
    "downleft": (-1, 1),
    "left": (-1, 0),
    "upleft": (-1, -1),
}

_Moore = {}


class milleri:
    def __init__(self) -> None:
        self.tracker = set()

    def add_to_tracker(self, coordinates: tuple[int, int]):
        self.tracker.add(coordinates)

    def step_strain(self, config: dict, image):
        # look at everything in the tracker, one by one.
        # for each item: process its own area
        old_set = self.tracker
        self.tracker = set()
        # print("Tracker spread: ", len(self.tracker))
        while old_set:
            cell = old_set.pop()
            spread = self.process(config, image, cell)
            if spread:
                for new_cell in spread:
                    if new_cell not in self.tracker and new_cell not in old_set:
                        self.tracker.add(new_cell)

        if self.tracker:
            return True
        return False

    def is_active(self, image, x, y):
        b, g, r = image[y, x]
        colors = [b, g, r]
        colors = list(map(int, colors))
        divided = sum(colors) // 3
        tolerance = 30
        """
        for c in [b, g, r]:
            if divided - tolerance > c > divided + tolerance:
                return False
        return True
        """
        if divided == 0 or divided == 255:
            return False
        return True

    def process(self, config: dict, image, cell: tuple):

        x, y = cell
        b, g, r = image[y, x]

        spread = []
        # determine if the current location has more work to do
        if not self.is_active(image, x, y):
            return spread

        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        # determine if the current location spreads
        for dx, dy in directions:
            nx = x + dx
            ny = y + dy
            if 0 > ny or ny > len(image):
                # print("else", x, y)
                continue
            elif 0 > nx or nx > len(image[0]):
                # print("elif", x, y)
                continue
            if self.is_active(image, nx, ny):
                # print(nx, ny)
                spread.append((nx, ny))

        # do any processing that needs to happen
        # black or white
        if sum([b, g, r]) // 2 > 256 // 2:
            image[y, x] = [255, 255, 255]
        else:
            image[y, x] = [0, 0, 0]
        return spread
