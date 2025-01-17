package br.com.matheusmaciel.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "company")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;
  @Email(message = "O campo [email] deve conter um email válido")
  private String email;

  @NotBlank(message = "O campo [username] deve ser preenchido")
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços")
  private String username;

  @Length(min = 8, max = 100, message = "A senha deve conter no mínimo 8 caracteres")
  private String password;
  private String description;
  private String website;

  @CreationTimestamp
  private LocalDateTime createdAt;

}
