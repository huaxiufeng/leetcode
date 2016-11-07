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
    vector<int> v;
    Solution s;
};

BOOST_FIXTURE_TEST_SUITE(s_assign, assign_fixture)
BOOST_AUTO_TEST_CASE(t_assign_1)
{
    v = s.getRow(3);
    BOOST_CHECK_EQUAL(v[0], 1);
    BOOST_CHECK_EQUAL(v[1], 3);
}

BOOST_AUTO_TEST_SUITE_END()
