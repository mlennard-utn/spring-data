package hello;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "job", path = "job")
public interface JobRepository extends PagingAndSortingRepository<Job, Long> {

}
