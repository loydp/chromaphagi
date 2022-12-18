import os
import cv2

import chromaphagi

def get_input_image(config):
    first_image_name = os.listdir(config['input_path'])[0]
    image = cv2.imread(config['input_path'] + first_image_name)
    config['file_name'] = first_image_name
    return image

def save_image(image, config):
    cv2.imwrite(f"{config['output_path']}{config['file_name']}", image)

def _setup(config):
    config['chromaphagi'] = config['chromaphagi']()


def main(config):
    image = get_input_image(config)

    _setup(config)

    cv2.imshow("Example", image)
    for i in range(config['max_runtime']):
        continue_running = config['chromaphagi'].step(config, image)
        if not continue_running:
            break
        cv2.imshow("Example", image)
        cv2.waitKey(config['speed'])
    
    save_image(image, config)
    return None

config = {
   "max_runtime" : 30,
   "speed" : 100,
   'start' : [(0, 0)],
   "output_path" : '../output/',
   "input_path" : '../input/',
   "chromaphagi" : None
}

if __name__ == '__main__':
   config['chromaphagi'] = chromaphagi.Milleri
   print("hello")
   main(config)
