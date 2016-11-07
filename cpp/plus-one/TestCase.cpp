#define BOOST_TEST_MAIN
#include <iostream>
#include <boost/test/included/unit_test.hpp>
#include <boost/assign.hpp>
using namespace std;
using namespace boost::assign;

#include "Solution.cpp"

struct global_fixture
{
    global_fixture()
    {
    }
    ~global_fixture()
    {
    }
};

BOOST_GLOBAL_FIXTURE(global_fixture);
struct assign_fixture
{
    assign_fixture()
    {
    }
    ~assign_fixture()
    {
    }
    Solution s;
};

BOOST_FIXTURE_TEST_SUITE(s_assign, assign_fixture)
BOOST_AUTO_TEST_CASE(t_assign_1)
{
  vector<int> v,r;
  v.push_back(1);
  v.push_back(2);
  v.push_back(3);
  r = s.plusOne(v);
  BOOST_CHECK_EQUAL(r.size(), 3);
  BOOST_CHECK_EQUAL(r[0], 1);
  BOOST_CHECK_EQUAL(r[1], 2);
  BOOST_CHECK_EQUAL(r[2], 4);
}

BOOST_AUTO_TEST_SUITE_END()
