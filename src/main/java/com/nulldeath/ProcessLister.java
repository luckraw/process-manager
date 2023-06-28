package com.nulldeath;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;

import java.util.ArrayList;
import java.util.List;

public class ProcessLister {
    public List<ProcessInfo> listProcesses() {
        List<ProcessInfo> processes = new ArrayList<>();
        Tlhelp32.PROCESSENTRY32.ByReference entry = new Tlhelp32.PROCESSENTRY32.ByReference();
        WinNT.HANDLE snapshot = Kernel32.INSTANCE.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));

        try {
            while (Kernel32.INSTANCE.Process32Next(snapshot, entry)) {
                String processName = Native.toString(entry.szExeFile);
                int processId = entry.th32ProcessID.intValue();
                processes.add(new ProcessInfo(processId, processName));
            }
        } finally {
            Kernel32.INSTANCE.CloseHandle(snapshot);
        }

        return processes;
    }
}

