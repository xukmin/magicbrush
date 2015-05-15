#!/bin/bash

function TransformImage() {
  local command="${1}"
  echo "Performing ${command} Transformation..."
  local input="samples/sample.jpg"
  local output="test/$(basename "${input}" .jpg)-${command}.jpg"
  java -cp bin org.xukmin.magicbrush.MagicBrushCli \
      "${@}" --input="${input}" --output="${output}"
}

function DiffImage() {
  local golden="samples/sample-${1}.jpg"
  local generated="test/sample-${1}.jpg"

  echo "Diffing ${golden} and ${generated}..."
  if ! diff "${golden}" "${generated}"; then
    echo "The ${1} transformation result is unexpected!"
    echo "Test Failed!"
    exit
  fi
}

function TestImage() {
  TransformImage "${@}"
  DiffImage "${1}"
}

function TestImages() {
  TestImage Mirror
  TestImage ColoredDots --background=white
  TestImage ColorCast
  TestImage ColorEnhance --upperMultiplier=1.35
  TestImage GrayScale
  TestImage Blur
  TestImage Recolor
  TestImage UpsideDown
  TestImage ColorInvert
  TestImage Wobble
}

function Test() {
  mkdir -p test
  TestImages
  echo "Test Passed!"
}

if (( $(ls samples | wc -l) <= 1 )); then
  echo "No golden files found for comparison!"
  echo "You may rerun ./generate-samples.sh to generate golden files."
  exit
fi

./build-magicbrush.sh
Test
