#!/bin/bash

function GenerateImage() {
  local command="${1}"
  echo "Generating Sample image for ${command} transformation..."
  local input="samples/sample.jpg"
  local output="samples/$(basename "${input}" .jpg)-${command}.jpg"
  java -cp bin org.xukmin.magicbrush.MagicBrushCli \
      "${@}" --input="${input}" --output="${output}"
}

function GenerateImages() {
  GenerateImage Mirror
  GenerateImage ColoredDots --background=white
  GenerateImage ColorCast
  GenerateImage ColorEnhance --upperMultiplier=1.35
  GenerateImage GrayScale
  GenerateImage Blur
  GenerateImage Recolor
  GenerateImage UpsideDown
  GenerateImage ColorInvert
  GenerateImage Wobble
  echo "Generating Samples is done."
}

./build-magicbrush.sh
GenerateImages
