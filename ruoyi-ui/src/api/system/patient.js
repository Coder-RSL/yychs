import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listPatient(query) {
  return request({
    url: '/system/patient/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getPatient(id) {
  return request({
    url: '/system/patient/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addPatient(data) {
  return request({
    url: '/system/patient',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updatePatient(data) {
  return request({
    url: '/system/patient',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delPatient(id) {
  return request({
    url: '/system/patient/' + id,
    method: 'delete'
  })
}
