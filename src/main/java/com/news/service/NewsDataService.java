package com.news.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.news.entity.NewsData;
import com.news.entity.vo.NewsType;
import com.news.entity.vo.PageVo;
import com.news.entity.vo.QueryVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Sancean
 * @since 2023-05-18
 */
public interface NewsDataService extends IService<NewsData> {
    /**
     * 查找新闻信息表
     * @return list<NewsData>集合
     */
    List<NewsData> getAllData();

    /**
     * 查找单个新闻信息
     * @param id 新闻ID
     * @return NewData对象
     */
    NewsData getData(Integer id);

    /**
     * 添加新闻信息
     * @param newsData 新闻实例
     * @return 添加成功(true)/添加失败(false)
     */
    boolean insertData(NewsData newsData);

    /**
     * 修改新闻信息
     * @param newsData 新闻实例
     * @return 修改成功(true)/修改失败(false)
     */
    boolean updateData(NewsData newsData);

    /**
     * 删除新闻信息
     * @param ids id集合
     * @return 删除成功(true)/删除失败(false)
     */
     boolean deleteData(String ids);

    /**
     * 分页条件查询新闻信息
     * @param queryVo 查询条件（起始页面和页面容量）
     * @return PageVo 前端页面封装
     */
    PageVo<NewsData> pageQueryByCondition(QueryVo queryVo);

    /**
     * 分页查询所有新闻详情
     * @param queryVo 查询条件({null})
     * @return PageVo 前端页面封装
     */
    PageVo<NewsType> pageQueryByConditionWithType(QueryVo queryVo);

}
