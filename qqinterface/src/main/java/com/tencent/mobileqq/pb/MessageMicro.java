package com.tencent.mobileqq.pb;

import java.lang.reflect.Field;
import java.util.Arrays;

public class MessageMicro<T extends MessageMicro<T>> {
    public static final class FieldMap {
        private Object[] defaultValues;
        private Field[] fields;
        private int[] tags;

        FieldMap(int[] iArr, String[] strArr, Object[] objArr, Class<?> cls) {
            this.tags = iArr;
            this.defaultValues = objArr;
            this.fields = new Field[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                try {
                    this.fields[i2] = cls.getField(strArr[i2]);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        void clear(MessageMicro<?> messageMicro) {
        }

        <U extends MessageMicro<U>> void copyFields(U u, U u2) {
        }

        Field get(int i2) {
            int binarySearch = Arrays.binarySearch(this.tags, i2);
            if (binarySearch < 0) {
                return null;
            }
            return this.fields[binarySearch];
        }

        int getSerializedSize(MessageMicro<?> messageMicro) {
            return 0;
        }
    }

    public static FieldMap initFieldMap(int[] iArr, String[] strArr, Object[] objArr, Class<?> cls) {
        return new FieldMap(iArr, strArr, objArr, cls);
    }

    public final T mergeFrom(byte[] bArr) {
        return null;
    }

    public final byte[] toByteArray() {
        return null;
    }

    public T get() {
        return null;
    }

    public void set(T t) {
    }
}
