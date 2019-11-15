package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.OrderReSeatNum;

public interface IOrderReSeatNumMapper {
	int totalNum(int bId);
	List<OrderReSeatNum> findPage(@Param("offset") int page,@Param("pageSize") int limit,@Param("bId") int bId);
}
