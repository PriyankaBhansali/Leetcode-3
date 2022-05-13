Algorithm:

Define boundaries:
Initiate left = 0 and right = 1.

While target is on the right to the high boundary: reader.get(high) < target:
Set left boundary equal to the right one: low = high.
Extend right boundary: high *= 2. To speed up, use right shift instead of multiplication: high <<= 1.
Now the target is between low and high boundaries.

You can do a Binary Search now.
