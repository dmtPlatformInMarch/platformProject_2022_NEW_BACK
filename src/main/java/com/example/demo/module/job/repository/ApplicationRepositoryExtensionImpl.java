package com.example.demo.module.job.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.job.domain.domain.QApplication;
import com.example.demo.module.job.domain.domain.QJob;
import com.example.demo.module.job.domain.dto.*;
import com.example.demo.module.project.domain.entity.Project;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Slf4j
public class ApplicationRepositoryExtensionImpl extends QuerydslRepositorySupport implements ApplicationRepositoryExtension {
    public ApplicationRepositoryExtensionImpl() {
        super(Application.class);
    }

    @Override
    public ApplicationDto findAppByWorkerByProjectAndWorker(Project project, Account worker) {
        QApplication application = QApplication.application;
        JPQLQuery<ApplicationDto> jpqlQuery = from(application)
                .where(application.project.eq(project)
                    .and(application.worker.eq(worker)))
                .select(new QApplicationDto(
                    application.id,
                        application.project.id.as("projectId"),
                        application.resume.id.as("resumeId"),
                        application.resume.title.as("resumeTitle"),
                        application.worker.email.as("workerEmail"),
                        application.worker.id.as("workerId"),
                        application.manager.id.as("managerId"),
                        application.manager.email.as("managerEmail"),
                        application.isWorkerApplied,
                        application.applicationContent,
                        application.applicationStatus.as("applicationStatus"),
                        application.createdDate,
                        application.lastModifiedDate
                ));

        return jpqlQuery.fetchOne();
    }

    @Override
    public List<ApplicationDto> findAppByManagerByProject(Project project, Account manager) {
        QApplication application = QApplication.application;
        JPQLQuery<ApplicationDto> jpqlQuery = from(application)
                .where(application.project.eq(project)
                        .and(application.manager.eq(manager)))
                .select(new QApplicationDto(
                        application.id,
                        application.project.id.as("projectId"),
                        application.resume.id.as("resumeId"),
                        application.resume.title.as("resumeTitle"),
                        application.worker.email.as("workerEmail"),
                        application.worker.id.as("workerId"),
                        application.manager.id.as("managerId"),
                        application.manager.email.as("managerEmail"),
                        application.isWorkerApplied,
                        application.applicationContent,
                        application.applicationStatus.as("applicationStatus"),
                        application.createdDate,
                        application.lastModifiedDate
                ));

        return jpqlQuery.fetch();
    }

    public ApplicationDto getOneById(Long id) {
        QApplication application = QApplication.application;
        JPQLQuery<ApplicationDto> jpqlQuery = from(application)
                .where(application.id.eq(id))
                .select(new QApplicationDto(
                        application.id,
                        application.project.id.as("projectId"),
                        application.resume.id.as("resumeId"),
                        application.resume.title.as("resumeTitle"),
                        application.worker.email.as("workerEmail"),
                        application.worker.id.as("workerId"),
                        application.manager.id.as("managerId"),
                        application.manager.email.as("managerEmail"),
                        application.isWorkerApplied,
                        application.applicationContent,
                        application.applicationStatus.as("applicationStatus"),
                        application.createdDate,
                        application.lastModifiedDate
                ));

        return jpqlQuery.fetchOne();
    }

    /*
    @Override
    public List<JobListDto> findByProjectId(Project project) {
        QJob job = QJob.job;
        JPQLQuery<JobListDto> jpqlQuery = from(job)
                .where(job.project.eq(project))
                .select(new QJobListDto(
                        job.id, job.isWorkerApplied, job.createdDate,
                        job.lastModifiedDate, job.applicationContent,
                        job.jobStatus.as("applicationStatus")
                ));
        return jpqlQuery.fetch();
    }

    @Override
    public List<JobListDto> findByProjectIdAndWorkerId(Project project, Account worker) {
        System.out.println("find by project id and worker id");
        QJob job = QJob.job;
        JPQLQuery<JobListDto> jpqlQuery = from(job)
                .where(job.project.eq(project)
                        .and(job.worker.eq(worker)))
                .select(new QJobListDto(
                        job.id, job.isWorkerApplied, job.createdDate,
                        job.lastModifiedDate, job.applicationContent,
                        job.jobStatus.as("applicationStatus")
                ));
        return jpqlQuery.fetch();
    }

    @Override
    public List<JobListDto> findByProjectIdAndManagerId(Project project, Account manager) {
        System.out.println("find by project id and worker id");
        QJob job = QJob.job;
        JPQLQuery<JobListDto> jpqlQuery = from(job)
                .where(job.project.eq(project)
                        .and(job.manager.eq(manager)))
                .select(new QJobListDto(
                        job.id, job.isWorkerApplied, job.createdDate,
                        job.lastModifiedDate, job.applicationContent,
                        job.jobStatus.as("applicationStatus")
                ));
        return jpqlQuery.fetch();
    }

    @Override
    public List<JobListDto> getAllApplicationAsManager(Project project, Account manager) {
        log.info("get all application as manager");
        QJob job = QJob.job;
        JPQLQuery<JobListDto> jpqlQuery = from(job)
                .where(job.project.eq(project)
                        .and(job.manager.eq(manager)))
                .select(new QJobListDto(
                        job.id, job.isWorkerApplied, //job.customFile.originalName.as("fileName") job.customFile.id.as("fileId"),
                        job.createdDate,
                        job.lastModifiedDate, job.applicationContent,
                        job.jobStatus.as("applicationStatus")
                ));
        return jpqlQuery.fetch();
    }

    @Override
    public List<JobListDto> getAllApplicationAsWorker(Project project, Account worker) {
        log.info("get all application as manager");
        QJob job = QJob.job;
        JPQLQuery<JobListDto> jpqlQuery = from(job)
                .where(job.project.eq(project)
                        .and(job.worker.eq(worker)))
                .select(new QJobListDto(
                        job.id, job.isWorkerApplied, //job.customFile.originalName.as("fileName") job.customFile.id.as("fileId"),
                        job.createdDate,
                        job.lastModifiedDate, job.applicationContent,
                        job.jobStatus.as("applicationStatus")
                ));
        return jpqlQuery.fetch();
    }

    @Override
    public List<JobApplicationDto> getApplicationAsWorker(Project project, Account worker) {
        QJob job = QJob.job;
        JPQLQuery<JobApplicationDto> jpqlQuery = from(job)
                .where(job.project.eq(project)
                        .and(job.worker.eq(worker))
                        .and(job.isWorkerApplied.isTrue())
                        .and(job.resume.isNotNull()))
                .select(new QJobApplicationDto(
                        job.id, job.isWorkerApplied, job.createdDate,
                        job.lastModifiedDate, job.applicationContent,
                        job.jobStatus.as("applicationStatus"),
                        job.resume.id.as("resumeId"),
                        job.resume.title
                ));

        return jpqlQuery.fetch();
    }
    */
}
