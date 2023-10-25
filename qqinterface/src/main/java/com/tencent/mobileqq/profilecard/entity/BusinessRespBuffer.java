package com.tencent.mobileqq.profilecard.entity;

import android.util.SparseArray;

import com.tencent.mobileqq.profilecard.SummaryCardBusiEntry;

import java.util.ArrayList;

public class BusinessRespBuffer {
    public byte[] buffer;
    public SummaryCardBusiEntry.comm comm;

    public BusinessRespBuffer(SummaryCardBusiEntry.comm comm, byte[] bArr) {
        this.comm = comm;
        this.buffer = bArr;
    }

    public static SparseArray<BusinessRespBuffer> parseBusinessRespBuffer(ArrayList<byte[]> arrayList) {
        SparseArray<BusinessRespBuffer> sparseArray = new SparseArray<>();
        return sparseArray;
    }
}