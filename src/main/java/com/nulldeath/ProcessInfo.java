package com.nulldeath;

public class ProcessInfo {
    private int processId;
    private String processName;
    private int parentProcessId;
    private int threadCount;
    private long basePriority;

    public ProcessInfo(int processId, String processName) {
        this.processId = processId;
        this.processName = processName;
    }

    public ProcessInfo(int processId, String processName, int parentProcessId, int threadCount, long basePriority) {
        this.processId = processId;
        this.processName = processName;
        this.parentProcessId = parentProcessId;
        this.threadCount = threadCount;
        this.basePriority = basePriority;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getParentProcessId() {
        return parentProcessId;
    }

    public void setParentProcessId(int parentProcessId) {
        this.parentProcessId = parentProcessId;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public long getBasePriority() {
        return basePriority;
    }

    public void setBasePriority(long basePriority) {
        this.basePriority = basePriority;
    }

    @Override
    public String toString() {
        return "ProcessInfo{" +
                "processId=" + processId +
                ", processName='" + processName + '\'' +
                ", parentProcessId=" + parentProcessId +
                ", threadCount=" + threadCount +
                ", basePriority=" + basePriority +
                '}';
    }
}
