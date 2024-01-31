package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProClientArchive {
    String archiveName;
    int clientId;
    GProSmobaArchiveTemplate template1;
    GProArchiveTemplate2 template2;
    int templateId;

    public GProClientArchive() {
        this.archiveName = "";
        this.template1 = new GProSmobaArchiveTemplate();
        this.template2 = new GProArchiveTemplate2();
    }

    public String getArchiveName() {
        return this.archiveName;
    }

    public int getClientId() {
        return this.clientId;
    }

    public GProSmobaArchiveTemplate getTemplate1() {
        return this.template1;
    }

    public GProArchiveTemplate2 getTemplate2() {
        return this.template2;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String toString() {
        return "GProClientArchive{clientId=" + this.clientId + ",archiveName=" + this.archiveName + ",templateId=" + this.templateId + ",template1=" + this.template1 + ",template2=" + this.template2 + ",}";
    }

    public GProClientArchive(int i2, String str, int i3, GProSmobaArchiveTemplate gProSmobaArchiveTemplate, GProArchiveTemplate2 gProArchiveTemplate2) {
        this.archiveName = "";
        this.template1 = new GProSmobaArchiveTemplate();
        this.template2 = new GProArchiveTemplate2();
        this.clientId = i2;
        this.archiveName = str;
        this.templateId = i3;
        this.template1 = gProSmobaArchiveTemplate;
        this.template2 = gProArchiveTemplate2;
    }
}
