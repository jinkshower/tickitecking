package com.laydowncoding.tickitecking.domain.auditorium.service;

import com.laydowncoding.tickitecking.domain.auditorium.dto.request.AuditoriumRequestDto;
import com.laydowncoding.tickitecking.domain.auditorium.dto.response.AuditoriumResponseDto;
import java.util.List;

public interface AuditoriumService {

  void createAuditorium(AuditoriumRequestDto auditoriumRequest);

  void updateAuditorium(AuditoriumRequestDto auditoriumRequest, Long auditoriumId);

  void deleteAuditorium(Long auditoriumId);

  List<AuditoriumResponseDto> getAuditoriums();

  AuditoriumResponseDto getAuditorium(Long auditoriumId);
}
