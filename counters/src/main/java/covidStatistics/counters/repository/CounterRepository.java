public interface UsersRepository implements JpaRepository<Counter, LocalDate> {
 
    List<Counter> findAll();
}