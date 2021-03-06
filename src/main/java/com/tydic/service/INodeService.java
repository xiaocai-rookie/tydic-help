package com.tydic.service;

import com.tydic.bean.NodeBean;
import com.tydic.common.Response;

import java.util.List;

/**
 * Created by hp on 2016/11/30.
 * 节点接口
 */
public interface INodeService {
    /**
     * 获取所有节点信息，不包括节点内容
     *
     * @return 所有的节点信息
     */
    Response<List<NodeBean>> findAllNodes();

    /**
     * 根据节点id，和父节点id获取该节点的详细内容
     *
     * @param id 节点id
     * @return 该节点的详细内容
     */
    Response<NodeBean> findNode(int id);

    /**
     * 向数据库插入节点
     *
     * @param bean     节点实体
     * @param hasChild 是否有子节点
     * @return 是否插入成功
     */
    Response<Boolean> insertNode(NodeBean bean, boolean hasChild);

    /**
     * 根据实体中的id修改叶子节点
     *
     * @param bean 叶子节点实体
     * @return 是否修改成功
     */
    Response<Boolean> updateNode(NodeBean bean);

    /**
     * 按照id删除叶子节点
     *
     * @param id 被删除的叶子节点id
     * @return 是否删除成功
     */
    Response<Boolean> delNode(int id);

    /**
     * 根据父节点id查找该父节点下所有的子节点，不包括子节点下的根子节点，即只查询一级
     *
     * @param fid 父节点id
     * @return 子节点集合
     */
    Response<List<NodeBean>> findNodesByFather(int fid);
}
