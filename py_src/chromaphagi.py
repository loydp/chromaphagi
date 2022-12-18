class Chromaphagi:

    def __init__(self) -> None:
        print("hello world")
        raise NotImplementedError()

    def step(self, config:dict, image) -> bool:
        raise NotImplementedError()



class Milleri(Chromaphagi):
    def __init__(self):
        self.tracker = {(0, 0)}

    def process(self, config, image, cell):
        
        # work on self
        x, y = cell
        b, g, r = image[x, y]
        if b == g == r:
            return []
        total = b + g + r
        divided = total // 3
        # TODO: 
        print(image[x, y])
                
        spread = []
        return spread

    def step(self, config, image):
        # look at everything in the tracker, one by one.
        tracker = self.tracker
        self.tracker = {}
        # for each item: process its own area
        for cell in tracker:
            spread = self.process(config, image, cell)
            if spread:
                for cell in spread:
                    if cell not in tracker:
                        self.tracker.add(cell)
        if not tracker:
            return False
        return True