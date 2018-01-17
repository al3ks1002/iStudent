package ro.ubb.istudent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.dto.CourseDto;
import ro.ubb.istudent.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private static final Logger LOG = LoggerFactory.getLogger(CourseService.class);

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public Optional<CourseDto> findCourseById(String courseId) {
        return repository.findCourseEntityById(courseId)
                .map(CourseDto::createDtoFromEntity);
    }

    public CourseDto createCourse(CourseDto course) {
        return CourseDto.createDtoFromEntity(repository.save(CourseDto.createEntityFromDto(course)));
    }

    public List<CourseDto> findAll() {
        return CourseDto.createDtosFromEntities(repository.findAll());
    }


}