import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listSchedule(query) {
  return request({
    url: '/system/schedule/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getSchedule(id) {
  return request({
    url: '/system/schedule/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addSchedule(data) {
  return request({
    url: '/system/schedule',
    method: 'post',
    data: data
  })
}

// system/schedule/addByForm
export function addByScheduleForm(data) {
  return request({
    url: '/system/schedule/addByForm',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateSchedule(data) {
  return request({
    url: '/system/schedule',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delSchedule(id) {
  return request({
    url: '/system/schedule/' + id,
    method: 'delete'
  })
}
