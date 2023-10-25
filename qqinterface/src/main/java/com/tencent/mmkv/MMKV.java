package com.tencent.mmkv;

import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;

public class MMKV implements SharedPreferences, SharedPreferences.Editor {
    @Override
    public Editor putString(String s, @Nullable String s1) {
        return null;
    }

    @Override
    public Editor putStringSet(String s, @Nullable Set<String> set) {
        return null;
    }

    @Override
    public Editor putInt(String s, int i) {
        return null;
    }

    @Override
    public Editor putLong(String s, long l) {
        return null;
    }

    @Override
    public Editor putFloat(String s, float v) {
        return null;
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this;
    }

    @Override
    public Editor remove(String s) {
        return null;
    }

    @Override
    public Editor clear() {
        return null;
    }

    @Override
    public boolean commit() {
        return false;
    }

    @Override
    public void apply() {

    }

    public native boolean tryLock();

    public native void unlock();

    @Override
    public Map<String, ?> getAll() {
        return null;
    }

    @Nullable
    @Override
    public String getString(String s, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public Set<String> getStringSet(String s, @Nullable Set<String> set) {
        return null;
    }

    @Override
    public int getInt(String s, int i) {
        return 0;
    }

    @Override
    public long getLong(String s, long l) {
        return 0;
    }

    @Override
    public float getFloat(String s, float v) {
        return 0;
    }

    @Override
    public boolean getBoolean(String s, boolean b) {
        return false;
    }

    @Override
    public boolean contains(String s) {
        return false;
    }

    @Override
    public Editor edit() {
        return null;
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {

    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {

    }
}
