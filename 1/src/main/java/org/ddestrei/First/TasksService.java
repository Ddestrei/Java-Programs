package org.ddestrei.First;

import org.ddestrei.First.tasks.fifth.Fifth;
import org.ddestrei.First.tasks.fifth.FifthTaskRepository;
import org.ddestrei.First.tasks.first.First;
import org.ddestrei.First.tasks.first.FirstTaskRepository;
import org.ddestrei.First.tasks.fourth.Fourth;
import org.ddestrei.First.tasks.fourth.FourthTaskRepository;
import org.ddestrei.First.tasks.second.Second;
import org.ddestrei.First.tasks.second.SecondTaskRepository;
import org.ddestrei.First.tasks.third.Third;
import org.ddestrei.First.tasks.third.ThirdTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TasksService {
    private final FirstTaskRepository firstTaskRepository;
    private final SecondTaskRepository secondTaskRepository;

    private final ThirdTaskRepository thirdTaskRepository;

    private final FourthTaskRepository fourthTaskRepository;
    private final FifthTaskRepository fifthTaskRepository;
    @Autowired
    public TasksService(FirstTaskRepository firstTaskRepository,
                        SecondTaskRepository secondTaskRepository,
                        ThirdTaskRepository thirdTaskRepository,
                        FourthTaskRepository fourthTaskRepository,
                        FifthTaskRepository fifthTaskRepository) {
        this.firstTaskRepository=firstTaskRepository;
        this.secondTaskRepository = secondTaskRepository;
        this.thirdTaskRepository = thirdTaskRepository;
        this.fourthTaskRepository = fourthTaskRepository;
        this.fifthTaskRepository = fifthTaskRepository;
    }
    public Collection<First> firstTask(){
        return this.firstTaskRepository.firstTask();
    }

    public Collection<Second> secondTask(){
        return this.secondTaskRepository.secondTask();
    }

    public Collection<Third> thirdTask(){
        return this.thirdTaskRepository.thirdTaks();
    }
    public Collection<Fourth> fourthTask(){
        return this.fourthTaskRepository.forthTask();
    }
    public Collection<Fifth> fifthTask(){
        return this.fifthTaskRepository.fifthTask();
    }
}
