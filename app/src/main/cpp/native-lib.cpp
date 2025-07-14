#include <jni.h>
#include <string>
using namespace std;
enum Operation{
    ADD = 0,
    SUBTRACT = 1,
    MULTIPLY = 2,
    DIVIDE = 3
};

extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_nativecalculatorapp_MainActivity_calculate(
        JNIEnv* env,
        jobject /* this */,jdouble a,jdouble b,jint operationCode) {
    Operation op = static_cast<Operation>(operationCode);
    double result = 0;

    switch(op)
    {
        case ADD:
            result = a + b;
            break;
        case SUBTRACT:
            result = a - b;
            break;
        case MULTIPLY:
            result = a * b;
            break;
        case DIVIDE:
            result = (b != 0) ? a / b : 0;
            break;
        default:
            result = 0;
            break;
    }

    return result;
}