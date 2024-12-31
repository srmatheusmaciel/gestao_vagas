package br.com.matheusmaciel.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.matheusmaciel.gestao_vagas.exceptions.JobNotFoundException;
import br.com.matheusmaciel.gestao_vagas.exceptions.UserNotFoundException;
import br.com.matheusmaciel.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.matheusmaciel.gestao_vagas.modules.company.repositories.JobRepository;

public class ApplyJobCandidateUseCase {

  @Autowired
  private JobRepository jobRepository;

  @Autowired
  private CandidateRepository candidateRepository;

  public void execute(UUID idCandidate, UUID idJob) {

    this.candidateRepository.findById(idCandidate)
    .orElseThrow(() -> {
      throw new UserNotFoundException();
    });

    this.jobRepository.findById(idJob)
    .orElseThrow(() -> {
      throw new JobNotFoundException();
    });


  };




}
