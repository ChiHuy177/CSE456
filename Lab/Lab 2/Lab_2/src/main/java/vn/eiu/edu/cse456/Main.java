package vn.eiu.edu.cse456;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.eiu.edu.cse456.entity.Student;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");

    public static void main(String[] args) {
//        insertStudent();
//        getStudentById("CSE2025001");
//        getAllStudents();
//        getStudentsByGpa();
//        deleteStudentById("CSE2025001");
        updateGpaById("CSE2025001",4);
        updateNameById("CSE2025001","Huy");
    }


    public static void insertStudent(){
//        1. Taọ người quản lý
        EntityManager em = emf.createEntityManager();

//        2. Chuẩn bị data để insert
        Student st1 = new Student();
        st1.setId("CSE2025004");
        st1.setName("Nguyen Thi BA");
        st1.setYOB(1999);
        st1.setGpa(3.9);

        Student st2 = new Student();
        st2.setId("CSE2025002");
        st2.setName("Nguyen Thi BA");
        st2.setYOB(1999);
        st2.setGpa(3.9);

        Student st3 = new Student();
        st3.setId("CSE2025003");
        st3.setName("Nguyen Thi BA");
        st3.setYOB(1999);
        st3.setGpa(3.9);

//        3. Insert
//        Khi thực thi câu lệnh sql dang DML(Data Manipulation Language: có làm thay đổi dữ liệu thì
//        bắt buộc phải trong 1 transaction để đảm bảo tính ACID: Atomy, Consistency, Isolation, Durability
//        Một là câu lệnh từ đầu đến cuối, còn ngược lại thì không làm gì cả, rollback
        em.getTransaction().begin();
        em.persist(st1); //ghi xuong database nhưng chưa lưu
        em.persist(st2);
        em.persist(st3);
        em.getTransaction().commit(); //lưu xuống database
        em.close();
    }

    static void getStudentById(String id){
        EntityManager em = emf.createEntityManager();

        Student st = em.find(Student.class, id);
        System.out.println("Studennt found: " + st);
    }

    static void getAllStudents(){
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery("select s from Student s", Student.class)
                .getResultList();
        System.out.println(students.size() +" Students found");
        students.forEach(System.out::println);
        em.close();
    }

    static void getStudentsByGpa(){
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery("select s from Student s where s.gpa > 3", Student.class)
                .getResultList();
        System.out.println(students.size() +" Students found");
        students.forEach(System.out::println);
        em.close();
    }

    static void deleteStudentById(String id){
        EntityManager em = emf.createEntityManager();
        Student st = em.find(Student.class, id);
        em.getTransaction().begin();
        em.remove(st);
        em.getTransaction().commit();
        em.close();
    }

    static void updateGpaById(String id, double newGpa) {
        EntityManager em = emf.createEntityManager();
        try {
            Student st = em.find(Student.class, id);
            if (st != null) {
                em.getTransaction().begin();
                st.setGpa(newGpa);
                em.getTransaction().commit();
                System.out.println("Cập nhật GPA thành công.");
            } else {
                System.out.println("Không tìm thấy sinh viên với ID: " + id);
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    static void updateNameById(String id, String newName) {
        EntityManager em = emf.createEntityManager();
        try {
            Student st = em.find(Student.class, id);
            if (st != null) {
                em.getTransaction().begin();
                st.setName(newName);
                em.getTransaction().commit();
                System.out.println("Cập nhật tên thành công.");
            } else {
                System.out.println("Không tìm thấy sinh viên với ID: " + id);
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}