#include <jni.h>

enum Operation {
    ADD = 0,
    SUBTRACT = 1,
    MULTIPLY = 2,
    DIVIDE = 3
};

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_nativecalculatorlibrary_CalculatorBridge_calculate(JNIEnv *env, jclass clazz,
                                                             jdouble a, jdouble b, jint opOrdinal) {
    Operation op = static_cast<Operation>(opOrdinal);
    switch (op) {
        case ADD: return a + b;
        case SUBTRACT: return a - b;
        case MULTIPLY: return a * b;
        case DIVIDE: return (b != 0) ? a / b : 0;
        default: return 0;
    }
}