#define BOOST_TEST_MAIN
#include <boost/test/included/unit_test.hpp>

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
    //BOOST_CHECK_EQUAL(s.atoi("    10522545459"), 2147483647);
}

BOOST_AUTO_TEST_SUITE_END()
