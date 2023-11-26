#include <jni.h>
#include <string>
#include <utility>
#include <sys/auxv.h>
#include <dlfcn.h>
#include "lsposed.h"

void on_library_loaded(const char *name, void *handle) {
    if (std::string(name) == "libc.so") {
        void *target = dlsym(handle, "__system_property_get");

    }
}

extern "C" [[gnu::visibility("default")]] [[gnu::used]]
NativeOnModuleLoaded native_init(const NativeAPIEntries *entries) {
    
    return on_library_loaded;
}