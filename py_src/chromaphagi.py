import os
import cv2

def get_input_image(config):
    first_image_name = os.listdir(config['input_path'])[0]
    image = cv2.imread(config['input_path'] + first_image_name)
    config['file_name'] = first_image_name
    return image

def save_image(image, name):
    output_contents = os.listdir(config['output_path'])
    num = 1
    if name in output_contents:
        suffix = f"_{num}"
        # TODO: put name stuff here
    cv2.imwrite(f"{config['output_path']}{config['file_name']}", image)

def main(config):
    # 1. take in.
    image = get_input_image(config)
    image[::-1, ::-1] = image[:, :]
    # 2. create petridish
    # 3. select strain
    # 4. Run it through, with config

    for i in range(len(image)):
        #print(image[i:i+1:])
        cv2.imshow("Example", image)
        image[i:i+1:, i:i+1:] = [255, 255, 255]
        cv2.waitKey(30)
    # TODO: run it through
    # 5. Repeat as needed
    # 6. Show result

    save_image(image, config)
    return None

if __name__ == '__main__':
    config = {
        "output_path": '../output/',
        "input_path": '../input/',
    }
    main(config)
