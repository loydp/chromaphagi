import os
import cv2

relative_input_path = '../input/'

def find_input_image_path():
    return os.listdir(relative_input_path)[0]

def main():
    # 1. take in.
    res = find_input_image_path()
    print(res)
    image = cv2.imread(relative_input_path + res)
    print(image)
    # 2. create petridish
    # 3. select strain
    # 4. Run it through, with config
    # 5. Repeat as needed
    # 6. Show result
    return None

if __name__ == '__main__':
    main()
