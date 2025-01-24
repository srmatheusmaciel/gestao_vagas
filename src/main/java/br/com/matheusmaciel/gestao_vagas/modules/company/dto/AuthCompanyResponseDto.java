package br.com.matheusmaciel.gestao_vagas.modules.company.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthCompanyResponseDto {

  private String access_token;
  private Long expires_in;
  private List<String> roles;
}
