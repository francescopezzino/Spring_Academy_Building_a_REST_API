package example.cashcard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

interface CashCardRepository extends CrudRepository<CashCard, Long>, PagingAndSortingRepository<CashCard, Long> {

    CashCard findByIdAndOwner(Long id, String owner);

    Page<CashCard> findByOwner(String owner, PageRequest pageRequest);

    /**
     * why not just use the findByIdAndOwner() method and check whether it returns null?
     * We could absolutely do that! But, such a call would return extra information
     * @param id
     * @param owner
     * @return
     */
    boolean existsByIdAndOwner(Long id, String owner);
}