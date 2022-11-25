import os
import cv2

relative_input_path = '../input/'

def get_input_image():
    first_image_name = os.listdir(relative_input_path)[0]
    image = cv2.imread(relative_input_path + first_image_name)
    return image, first_image_name

def save_image(image, name):
    output_contents = os.listdir(relative_input_path)
    num = 1
    if name in output_contents:
        suffix = f"_{num}"
        # TODO: put name stuff here
    cv2.imwrite(f"../output/output.jpg", image)

def main():
    # 1. take in.
    image, name = get_input_image()
    image[::-1, ::-1] = image[:, :]
    # 2. create petridish
    # 3. select strain
    # 4. Run it through, with config

    for i in range(len(image)):
        #print(image[i:i+1:])
        cv2.imshow("Example", image)
        image[i:i+1:, i:i+1:] = [255, 255, 255]
        cv2.waitKey(300)
    # TODO: run it through
    # 5. Repeat as needed
    # 6. Show result

    save_image(image, name)
    return None

if __name__ == '__main__':
    main()
