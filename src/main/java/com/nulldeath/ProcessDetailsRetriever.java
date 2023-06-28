package com.nulldeath;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;

public class ProcessDetailsRetriever {
    public ProcessInfo getDetailedProcessInfo(String processName) {
        Tlhelp32.PROCESSENTRY32.ByReference entry = new Tlhelp32.PROCESSENTRY32.ByReference();
        WinNT.HANDLE snapshot = Kernel32.INSTANCE.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));

        try {
            while (Kernel32.INSTANCE.Process32Next(snapshot, entry)) {
                String entryProcessName = Native.toString(entry.szExeFile);
                if (entryProcessName.equalsIgnoreCase(processName)) {
                    int processId = entry.th32ProcessID.intValue();
                    int parentProcessId = entry.th32ParentProcessID.intValue();
                    int threadCount = entry.cntThreads.intValue();
                    long basePriority = entry.pcPriClassBase.intValue();
                    return new ProcessInfo(processId, processName, parentProcessId, threadCount, basePriority);
                }
            }
        } finally {
            Kernel32.INSTANCE.CloseHandle(snapshot);
        }

        return null;
    }
}

