import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listForm(query) {
  return request({
    url: '/system/form/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getForm(id) {
  return request({
    url: '/system/form/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addForm(data) {
  return request({
    url: '/system/form',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateForm(data) {
  return request({
    url: '/system/form',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delForm(id) {
  return request({
    url: '/system/form/' + id,
    method: 'delete'
  })
}
