<h2>Chromaphagi</h2>
Chromaphagi is a cellular automata based image editing platform.
About.

Created by Peter Loyd in 2020, as a student at Seattle University.

Image I/O takes an image and puts it into a 3d array, with the z axis
representing RGB channels. Tasks: check to see if image is there, load it,
turn it into an array, save it.

The image is then treated with cellular automata, which work until a certain
point and then stop. They use 1 color as a resource. By consuming that
 resource they take another resource and collect it and move in a direction.
 When it expires, it does something else, maybe removes a bit of
 color 3.

(during, figure out basic format)

1. Check color r, if above 63 take half for power.
2. If more than 127 replicate in a random direction with more than 63.
2. If power < 15, die, dropping B up to 255.
    If powered, pick up half of remaining b.
3. Ask neighbors what direction to go. Go in that direction.
    If location has more than 255, including own, and no nodes, drop there
    first, then here.
4. have random direction if no direction given, nobody near.

When the CA are done, the image is saved.