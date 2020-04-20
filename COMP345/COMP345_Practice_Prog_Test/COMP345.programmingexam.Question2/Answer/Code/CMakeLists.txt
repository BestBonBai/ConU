cmake_minimum_required(VERSION 3.15)
project(LinkedList VERSION 0.1
    DESCRIPTION "A simple upgraded linked list with operators")

set(CMAKE_CXX_STANDARD 11)

file(GLOB driver main.cpp)

add_executable(linkedList ${driver})
install(TARGETS linkedList DESTINATION ./BUILD)
