import os
import cv2
import chromaphagi


class Petri_Dish:
    def __init__(self, image: cv2.Mat) -> None:
        self.image = image
        self.phagi = []
        self.config = None

    def inoculate(self, culture, coordinates=None) -> None:
        if not coordinates:
            y = len(self.image) // 2
            x = len(self.image[0]) // 2
            coordinates = (x, y)
        print(coordinates)
        culture.set_start_position(coordinates)
        self.phagi.append(culture)

    def run(self) -> cv2.Mat:
        image = self.image
        cv2.imshow("Example", image)
        for i in range(config["max_runtime"]):
            for phagi in self.phagi:
                continue_running = phagi.step(config, image)
                # TODO, this stuff is if multiple strains exist simultaneously.
                if not continue_running:
                    break
            cv2.imshow("Example", image)
            cv2.waitKey(config["speed"])
        return image


def get_input_image(config) -> cv2.Mat:
    first_image_name = os.listdir(config["input_path"])[0]
    image = cv2.imread(config["input_path"] + first_image_name)
    config["file_name"] = first_image_name
    return image


def save_image(image, config):
    cv2.imwrite(f"{config['output_path']}{config['file_name']}", image)


def main(config):
    """Take an image, put it in a petri-dish, then take a cellular automata strain and release it upon the image"""
    # get the image
    img = get_input_image(config)
    # create the petri dish
    petri_dish = Petri_Dish(img)
    # create the chromaphagi strain
    phagi = chromaphagi.chromaphagi(["milleri"])
    petri_dish.inoculate(phagi, None)
    # activate the chromaphagi strain
    decayed_image = petri_dish.run()
    # save/store the image
    save_image(decayed_image, config)

    return None


config = {
    "max_runtime": 3000,
    "speed": 1,
    "start": None,
    "output_path": "output/",
    "input_path": "input/",
    "chromaphagi": {
        "milleri": chromaphagi.milleri,
    },
}


if __name__ == "__main__":
    main(config)
