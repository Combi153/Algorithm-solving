/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
 */
var floodFill = function (image, sr, sc, color) {
  changeColor(image, sr, sc, color);
  return image;
};

const directions = {
  up: [0, -1],
  down: [0, 1],
  left: [-1, 0],
  right: [1, 0],
};

function changeColor(image, sr, sc, color) {
  const targetPixel = image[sr][sc];
  if (targetPixel === color) {
    return;
  }
  image[sr][sc] = color;

  for (let [direction, position] of Object.entries(directions)) {
    const [x, y] = position;
    if (
      sr + y > image.length - 1 ||
      sr + y < 0 ||
      sc + x > image[0].length - 1 ||
      sc + x < 0
    ) {
      continue;
    }
    const adjustedY = sr + y;
    const adjustedX = sc + x;
    const adjacentPixel = image[adjustedY][adjustedX];

    if (adjacentPixel === targetPixel) {
      changeColor(image, adjustedY, adjustedX, color);
      image[adjustedY][adjustedX] = color;
    }
  }
}
