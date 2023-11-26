cmake_minimum_required(VERSION 3.22.1)

set(CMAKE_CXX_STANDARD 23)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

project("clover")

include_directories(helper)

add_library(${CMAKE_PROJECT_NAME} SHARED
        anti_detection/anti_detection.cpp
        helper/jnihelper.cpp
        clover.cpp)

target_link_libraries(${CMAKE_PROJECT_NAME}
    android
    log)
