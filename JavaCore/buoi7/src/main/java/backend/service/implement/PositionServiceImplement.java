package backend.service.implement;

import backend.repository.IPositionRepository;
import backend.repository.implement.PositionRepositoryImplement;
import backend.service.IPositionService;
import entity.Postion;

import java.util.List;

public class PositionServiceImplement implements IPositionService {
    IPositionRepository positionRepository ;
    public PositionServiceImplement() {
        positionRepository = new PositionRepositoryImplement();
    }
    @Override
    public boolean kiemTraTonTaiPostionId(Integer positionId) {
        return positionRepository.kiemTraTonTaiPostionId(positionId);
    }

    @Override
    public Postion getPostionById(int positionId) {
        return positionRepository.getPostionById(positionId);
    }

    @Override
    public List<Postion> getPostions() {
        return positionRepository.getPostions();
    }

}
