package com.example.demo.module.job.domain.domain;

public enum ApplicationStatus {
    ManagerApplied, WorkerApplied,
    ManagerAppliedAndWorkerConfirmed,
    WorkerAppliedAndManagerConfirmed,
    ManagerAppliedAndWorkerCanceled,
    WorkerAppliedAndManagerCanceled,
    WorkerAppliedAndWorkerCanceled,
    ManagerAppliedAndManagerCanceled
}
