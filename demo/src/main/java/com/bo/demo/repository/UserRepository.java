package com.bo.demo.repository;
import com.bo.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {


    /**
     * 内存型
     */
    private final ConcurrentMap<Integer,User> repository
            = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerater = new AtomicInteger();

    /**
     * 保存用户对象
     * @param user {@link User} 对象
     * @return 保存成功，返回true，
     *          否则，返回false
     */
    public boolean save(User user){

        Integer id = idGenerater.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;//成功就返回null
    }

    /**
     *
     *
     * @return user {@link User}
     */
    public Collection<User> findAll(){

        return repository.values();//成功就返回null
    }
}
