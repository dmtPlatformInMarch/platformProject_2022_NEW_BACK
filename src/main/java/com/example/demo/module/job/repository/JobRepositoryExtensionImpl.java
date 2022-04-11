package com.example.demo.module.job.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.job.domain.domain.Job;
import com.example.demo.module.job.domain.domain.QJob;
import com.example.demo.module.job.domain.dto.JobApplicationDto;
import com.example.demo.module.job.domain.dto.JobListDto;
import com.example.demo.module.job.domain.dto.QJobApplicationDto;
import com.example.demo.module.job.domain.dto.QJobListDto;
import com.example.demo.module.project.domain.entity.Project;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OneToMany;
import java.util.List;

@Slf4j
public class JobRepositoryExtensionImpl extends QuerydslRepositorySupport implements JobRepositoryExtension {
    public JobRepositoryExtensionImpl() {
        super(Job.class);
    }

    @Override
    public List<JobListDto> findJobsByProject(Project project) {
        QJob job = QJob.job;
        JPQLQuery<JobListDto> jpqlQuery = from(job)
                .where(job.project.eq(project))
                .select(new QJobListDto(
                       job.id, job.customFile.id.as("fileId"), job.customFile.originalName.as("fileName"),
                        job.application.id.as("applicationId"), job.project.id.as("projectId"),
                        job.jobStatus, job.createdDate, job.lastModifiedDate
                ));
        return jpqlQuery.fetch();
    }

    @Override
    public List<JobListDto> findJobsByApplication(Application application) {
        QJob job = QJob.job;
        JPQLQuery<JobListDto> jpqlQuery = from(job)
                .where(job.application.eq(application))
                .select(new QJobListDto(
                        job.id, job.customFile.id.as("fileId"), job.customFile.originalName.as("fileName"),
                        job.application.id.as("applicationId"), job.project.id.as("projectId"),
                        job.jobStatus, job.createdDate, job.lastModifiedDate
                ));
        return jpqlQuery.fetch();
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
