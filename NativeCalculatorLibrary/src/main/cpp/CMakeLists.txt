cmake_minimum_required(VERSION 3.22.1)

project("NativeCalculatorLibrary")

#add_library(${CMAKE_PROJECT_NAME} SHARED
# List C/C++ source files with relative paths to this CMakeLists.txt.
#     native-lib.cpp)

add_library(native-lib SHARED native-lib.cpp)


target_link_libraries(native-lib
        # List libraries link to the target library
        android
        log)