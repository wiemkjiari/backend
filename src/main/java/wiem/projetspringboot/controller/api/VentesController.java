package wiem.projetspringboot.controller.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import wiem.projetspringboot.Dto.VentesDto;
import wiem.projetspringboot.controller.api.api.VentesApi;
import wiem.projetspringboot.services.VentesService;

import java.util.List;

@RestController
public class VentesController implements VentesApi {

    private VentesService ventesService;

   // @Autowired
  //  public VentesController(VentesService ventesService) {
   //     this.ventesService = ventesService;


    @Override
    public VentesDto save(VentesDto dto) {
        return ventesService.save(dto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return ventesService.findById(id);
    }

    @Override
    public VentesDto findByCode(String code) {
        return ventesService.findByCode(code);
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesService.findAll();
    }

    @Override
    public void delete(Integer id) {
        ventesService.delete(id);
    }
}

