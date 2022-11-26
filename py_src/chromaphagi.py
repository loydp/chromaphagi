import os
import cv2

def get_input_image(config):
    first_image_name = os.listdir(config['input_path'])[0]
    image = cv2.imread(config['input_path'] + first_image_name)
    config['file_name'] = first_image_name
    return image

def save_image(image, config):
    cv2.imwrite(f"{config['output_path']}{config['file_name']}", image)

def _setup(config):
    pass


def _process(config):
    return True

def main(config):
    image = get_input_image(config)

    _setup(config)

    cv2.imshow("Example", image)
    for i in range(50):
        continue_running = _process(config)
        if not continue_running:
            break
        cv2.imshow("Example", image)
        cv2.waitKey(config['speed'])

    save_image(image, config)
    return None

if __name__ == '__main__':
    config = {
        "speed": 300,
        "output_path": '../output/',
        "input_path": '../input/',
    }
    main(config)
