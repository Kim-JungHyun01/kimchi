package com.kr.kimchi.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonParams {

    private int page;               // ���� ������ ��ȣ
    private int recordPerPage;      // �������� ����� ������ ����
    private int pageSize;           // ȭ�� �ϴܿ� ����� ������ ����
    private String keyword;         // �˻� Ű����
    private String searchType;      // �˻� ����
    private Pagination pagination;  // ���������̼� ����

}