cmake_minimum_required(VERSION 3.15)
project(myArray VERSION 1.0)

set(CMAKE_CXX_STANDARD 11)

file(GLOB files main.h main.cpp)

add_executable(myArray ${files})
install(TARGETS myArray DESTINATION build)
