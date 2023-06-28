package com.nulldeath;

import java.util.List;

public class ProcessManager {
    public static void main(String[] args) {
        ProcessManager processManager = new ProcessManager();

        List<ProcessInfo> processes = processManager.listProcesses();
        if (processes.isEmpty()) {
            System.out.println("Nenhum processo em execução.");
        } else {
            System.out.println("Processos em execução:");
            for (ProcessInfo process : processes) {
                System.out.println(process);
            }
        }

        String processName = "notepad.exe";
        ProcessInfo detailedProcess = processManager.getDetailedProcessInfo(processName);
        if (detailedProcess != null) {
            System.out.println("\nInformações detalhadas do processo:");
            System.out.println(detailedProcess);
        } else {
            System.out.println("\nProcesso não encontrado.");
        }
    }

    public List<ProcessInfo> listProcesses() {
        ProcessLister lister = new ProcessLister();
        return lister.listProcesses();
    }

    public ProcessInfo getDetailedProcessInfo(String processName) {
        ProcessDetailsRetriever retriever = new ProcessDetailsRetriever();
        return retriever.getDetailedProcessInfo(processName);
    }
}

