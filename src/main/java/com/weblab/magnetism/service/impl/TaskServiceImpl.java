package com.weblab.magnetism.service.impl;

import com.weblab.magnetism.model.Task;
import com.weblab.magnetism.repository.TaskRepository;
import com.weblab.magnetism.service.interf.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends AbstractCRUDService<Task, Long> implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    CrudRepository<Task, Long> getRepository() {
        return taskRepository;
    }
}